package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.CommentDTO;
import com.itwillbs.domain.NoticeDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.QnaDTO;
import com.itwillbs.service.NoticeService;
import com.itwillbs.service.QnaService;

@Controller
public class NoticeController {

	@Inject
	private NoticeService noticeService;
	
	//	가상주소 http://localhost:8080/Team_1/board/write
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		System.out.println("NoticeController write() ");

		// /WEB-INF/views/center/write.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/write";
	}

	//	가상주소 http://localhost:8080/Team_1/board/writePro
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String writePro(NoticeDTO noticeDTO) {
		System.out.println("NoticeController writePro() ");
		// member_id
		noticeDTO.setMember_id(2);

		noticeService.writeBoard(noticeDTO);
		// /WEB-INF/views/center/write.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "redirect:/board/list";

	}

	//	가상주소 http://localhost:8080/Team_1/board/list
	//	가상주소 http://localhost:8080/Team_1/board/list?pageNum=3
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		System.out.println("NoticeController list() ");
		// 한화면에 보여줄 글개수 설정
		int pageSize = 15;

		// pageNum 파라미터값 가져오기 => 없으면 1페이지 설정
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}

		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);

		List<NoticeDTO> boardList = noticeService.getBoardList(pageDTO);

		// 전체 글개수 구하기 => 디비에서 가져오기
		// int 리턴할형 getBoardCount() 메서드 정의
		// select count(*) from board
		// int count=bDAO.getBoardCount();
		int count = noticeService.getBoardCount();

		int currentPage = Integer.parseInt(pageNum);
		int pageBlock = 10;
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		if (endPage > pageCount) {
			endPage = pageCount;
		}

		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);

		// 디비에서 가져온 글을 model 담아서 notice.jsp 전달 *****??
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);

		// /WEB-INF/views/center/notice.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/board";
	}



	// 가상주소 http://localhost:8080/Team_1/board/update?num=1
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		System.out.println("NoticeController update() ");
		int num = Integer.parseInt(request.getParameter("id"));

		// num에 대한 글 가져오기
		NoticeDTO noticeDTO = noticeService.getBoard(num);

		// 디비에서 가져온 글을 model 담아서 update.jsp 전달
		model.addAttribute("noticeDTO", noticeDTO);

		// /WEB-INF/views/center/update.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/update";
	}

	//	가상주소 http://localhost:8080/Team_1/board/updatePro
	@RequestMapping(value = "/board/updatePro", method = RequestMethod.POST)
	public String updatePro(NoticeDTO noticeDTO) {
		System.out.println("NoticeController updatePro() ");

		noticeService.updateBoard(noticeDTO);

		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// response.sendRedirect("/board/list");
		return "redirect:/board/list";
	}

	// 가상주소 http://localhost:8080/Team_1/board/delete?num=1
	// /board/delete get방식
	// deleteBoard(boardDTO);
	// redirect:/board/list
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		System.out.println("NoticeController delete() ");
//		int num=Integer.parseInt(request.getParameter("num"));

		String number = request.getParameter("id");
		int num = Integer.parseInt(number);
		// num에 대한 글 삭제
		noticeService.deleteBoard(num);

		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// response.sendRedirect("/board/list");
		return "redirect:/board/list";
	}
}
