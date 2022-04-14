package com.itwillbs.controller;

import java.util.List;

/*import javax.annotation.Resource;*/
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.QnaDTO;
import com.itwillbs.domain.CommentDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.QnaService;

@Controller
public class QnaController {

//	QnaService boardService=new QnaServiceImpl();
	@Inject
	private QnaService qnaService;

	/*
	 * //파일경로 xml 받아옴
	 * 
	 * @Resource(name = "uploadPath") private String uploadPath;
	 */

//	가상주소 http://localhost:8080/Team_1/board/qnawrite
	@RequestMapping(value = "/board/qnawrite", method = RequestMethod.GET)
	public String qnawrite() {
		System.out.println("QnaController qnawrite() ");

		// /WEB-INF/views/center/qnawrite.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/qnawrite";
	}

//	가상주소 http://localhost:8080/Team_1/board/qnawritePro
	@RequestMapping(value = "/board/qnawritePro", method = RequestMethod.POST)
	public String qnawritePro(QnaDTO qnaDTO) {
		System.out.println("QnaController qnawritePro() ");
		// member_id
		/* qnaDTO.setMember_id(2); */

		qnaService.qnawriteBoard(qnaDTO);
		// /WEB-INF/views/center/qnawrite.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "redirect:/board/list";

	}

//	가상주소 http://localhost:8080/Team_1/board/list
//	가상주소 http://localhost:8080/Team_1/board/list?pageNum=3
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		System.out.println("QnaController list() ");
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

		List<QnaDTO> boardList = qnaService.getBoardList(pageDTO);

		// 전체 글개수 구하기 => 디비에서 가져오기
		// int 리턴할형 getBoardCount() 메서드 정의
		// select count(*) from board
		// int count=bDAO.getBoardCount();
		int count = qnaService.getBoardCount();

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

	// 가상주소 http://localhost:8080/Team_1/board/content?num=1
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		System.out.println("QnaController content() ");
		/*
		 * int num=Integer.parseInt(request.getParameter("num")); String number =
		 * request.getParameter("num").trim();
		 */
		String number = request.getParameter("id");
		int num = Integer.parseInt(number);

		// 조회수 증가 update board set readcount=readcount+1 where num=?
		qnaService.updateReadcount(num);

		// num에 대한 글 가져오기
		QnaDTO qnaDTO = qnaService.getBoard(num);
		int qna_board_id = num;
		CommentDTO commentDTO = qnaService.getCommentBoard(qna_board_id);

		System.out.println(commentDTO);

		// 디비에서 가져온 글을 model 담아서 content.jsp 전달
		model.addAttribute("qnaDTO", qnaDTO);
		model.addAttribute("commentDTO", commentDTO);

		// /WEB-INF/views/center/content.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/content";
	}

	// 가상주소 http://localhost:8080/Team_1/board/update?num=1
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		System.out.println("QnaController update() ");
		int num = Integer.parseInt(request.getParameter("id"));

		// num에 대한 글 가져오기
		QnaDTO qnaDTO = qnaService.getBoard(num);

		// 디비에서 가져온 글을 model 담아서 update.jsp 전달
		model.addAttribute("qnaDTO", qnaDTO);

		// /WEB-INF/views/center/update.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/update";
	}

//		가상주소 http://localhost:8080/Team_1/board/updatePro
	@RequestMapping(value = "/board/updatePro", method = RequestMethod.POST)
	public String updatePro(QnaDTO qnaDTO) {
		System.out.println("QnaController updatePro() ");

		qnaService.updateBoard(qnaDTO);

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
		System.out.println("QnaController delete() ");
//			int num=Integer.parseInt(request.getParameter("num"));

		String number = request.getParameter("id");
		int num = Integer.parseInt(number);
		// num에 대한 글 삭제
		qnaService.deleteBoard(num);

		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// response.sendRedirect("/board/list");
		return "redirect:/board/list";
	}

//	가상주소 http://localhost:8080/Team_1/board/comment
	@RequestMapping(value = "/board/comment", method = RequestMethod.GET)
	public String comment() {
		System.out.println("QnaController comment() ");

		// /WEB-INF/views/center/comment.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/comment";
	}

//	가상주소 http://localhost:8080/Team_1/board/commentPro
	@RequestMapping(value = "/board/commentPro", method = RequestMethod.POST)
	public String commentPro(CommentDTO commentDTO) {
		System.out.println("QnaController commentPro() ");
		// member_id
		commentDTO.setMember_id(2);   // **
		
		/*System.out.println(commentDTO.getContent());
		System.out.println(commentDTO.getId());
		System.out.println(commentDTO.getMember_id());
		System.out.println(commentDTO.getQna_board_id());
		System.out.println(commentDTO.getDate());*/
		
		qnaService.commentBoard(commentDTO);

		
		return "redirect:/board/content?id=" + commentDTO.getQna_board_id();

	}

//  가상주소 http://localhost:8080/Team_1/board/content?id=1
	@RequestMapping(value = "/board/commentupdate", method = RequestMethod.GET)
	public String commentupdate(HttpServletRequest request, Model model) {
		System.out.println("QnaController commentupdate() ");
		int num = Integer.parseInt(request.getParameter("id"));

		// num에 대한 글 가져오기
		int qna_board_id = num;
		CommentDTO commentDTO = qnaService.getCommentBoard(qna_board_id);

		// 디비에서 가져온 글을 model 담아서 update.jsp 전달
		model.addAttribute("commentDTO", commentDTO);
 
		
		return "redirect:/board/content?id="+qna_board_id; 
	}

//	가상주소 http://localhost:8080/Team_1/board/commentupdatePro
	@RequestMapping(value = "/board/commentupdatePro", method = RequestMethod.POST)
	public String commentupdatePro(CommentDTO commentDTO) {
		System.out.println("QnaController commentupdatePro() ");

		qnaService.commentupdateBoard(commentDTO);
		System.out.println(commentDTO.getQna_board_id());
		//return "redirect:/board/list";
		//return "center/content?id="+commentDTO.getQna_board_id(); 
		return "redirect:/board/content?id="+commentDTO.getQna_board_id(); 
	}
	
//  가상주소 http://localhost:8080/Team_1/board/commentdelete?num=1
	// /board/commentdelete get방식
	// commentdeleteBoard(boardDTO);
	// redirect:/board/list
	@RequestMapping(value = "/board/commentdelete", method = RequestMethod.GET)
	public String commentdelete(HttpServletRequest request) {
		System.out.println("QnaController commentdelete() ");
//		int num=Integer.parseInt(request.getParameter("num"));

		String number = request.getParameter("id");
		int num = Integer.parseInt(number);
		// num에 대한 글 삭제
		qnaService.commentdeleteBoard(num);

		// 가상주소 로그인주소 이동 /board/list (주소줄에 주소가 바뀌면서 이동)
		// response.sendRedirect("/board/list");
		return "redirect:/board/list";
		//return "center/content";
		
		
	}
	
//	가상주소 http://localhost:8080/Team_1/board/search
	@RequestMapping(value = "/board/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		System.out.println("QnaController search() ");
		// 검색어 가져오기
		String search = request.getParameter("search");
		String search2 = "%" + search + "%";

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
		pageDTO.setSearch(search2);

		List<QnaDTO> boardList = qnaService.getBoardListSearch(pageDTO);

		// 전체 글개수 구하기 => 디비에서 가져오기
		// int 리턴할형 getBoardCount() 메서드 정의
		// select count(*) from board
		// int count=bDAO.getBoardCount();
		int count = qnaService.getBoardCountSearch(pageDTO);

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

		// 검색어
		pageDTO.setSearch(search);

		// 디비에서 가져온 글을 model 담아서 notice.jsp 전달
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);

		// /WEB-INF/views/center/qnasearch.jsp 이동(주소줄에 주소가 안바뀌면서 이동)
		return "center/qnasearch";
	}

}
