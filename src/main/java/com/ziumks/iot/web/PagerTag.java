package com.ziumks.iot.web;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
public class PagerTag {
	
	public static int barSize = 10;
	
	public static String by(Page pageSource, String uri) {
		// 한페이지당 라인 수
		int size = pageSource.getSize();
		// 현재 페이지 넘버
		int page = pageSource.getNumber();
		// 전체 페이지 수
		int totalPage = pageSource.getTotalPages() -1;

		// 요청 페이지가 전체 페이지보다 크면 에러
		if (page > totalPage) return "";

		// 소트 파라미터를 만듬.
		String sortStr = "";
		// 기존 요청의 소트를 가져온다.
		Sort sort = pageSource.getSort();
		// 소트 기준이 여러 필드일 수 있으므로, 근데 그런일이 있을 수 있나?
		for(  Iterator<Sort.Order> itr = sort.iterator(); itr.hasNext(); ) {
			Sort.Order order = itr.next();
			String key = order.getProperty();
			Sort.Direction or = order.getDirection();
			String orderStr =  or == Sort.Direction.ASC ? "asc" : "desc";
			sortStr += "&sort=" + key +","+ orderStr ;
		}


		// pagebar의 첫번째 페이지 ( 11, 12, 13, 14,1 5, 16, 17, 18, 19, 20 ) 에서 11을 말함. 링크 용으로 -1을 해줘서 10이 된다. 화면에 표시는 11로.
		int startPage = ((int)((page )  / barSize)) * barSize  ;

		// pageBar의 마지막 페이지  ( 11, 12, 13, 14,1 5, 16, 17, 18, 19, 20 ) 에서 20을 말함. 링크 용으로 -1을 해줘서 19가 된다. 화면에 표시는 20으로. 
		int endPage = ((int)((page )  / barSize)) * barSize + barSize -1 ;

		// 단 마지막 페이지가 전체 페이지 보다 크면 전체페이지까지만 
		if(endPage > totalPage){
			endPage = totalPage;
		}

		// 첫번째 페이지가 1에서 10사이면 첫페이지가기와 이전 페이지 가기를 표시하지 않음.
		int prevPage = -1;
		int firstPage = -1;

		if( startPage >= barSize ) {
			firstPage = 0;
			prevPage = startPage -1;
		}

		// 마지막 표시 바에서는 마지막페이지가기와 다음 페이지 표시를 하지 않음.
		int nextPage = -1;
		int lastPage = -1;
		if( ( totalPage - startPage ) >= barSize ) {
			nextPage = endPage + 1;
			lastPage = totalPage;
		}
			
		String url = uri + "?page=";

		String tagStr = "<ul class=\"pagination align-self-center\">\n";

		if ( prevPage != -1 ) {
			tagStr += "<li class=\"page-item\"><a href=\""+ url + firstPage + "&size=" + size +  sortStr + "\"  class=\"page-link\"><i class=\"icon-arrow-left12\"></i></a></li> \n" ;
			tagStr += "<li class=\"page-item\"><a href=\""+ url + prevPage + "&size=" + size +  sortStr + "\"  class=\"page-link\"> &nbsp; 이전</a></li>  \n" ;
		}

		int opPage = 0;
		for (int i = 0; i < barSize; i++ ) {
			opPage = startPage+i;
			if (opPage > totalPage) break;
			if (opPage == page) {
				tagStr += "<li class=\"page-item active\" ><a href=\""+ url +  (startPage + i) + "&size=" + size +  sortStr + "\"  class=\"page-link\"> " + (startPage + i +1) +  " </a></li> \n";
			} else {
				tagStr += "<li class=\"page-item\"><a href=\""+ url +   (startPage + i) + "&size=" + size + sortStr + "\"  class=\"page-link\"> " + (startPage + i +1) +  " </a></li> \n";
			}
		}
		if ( lastPage != -1 ) {
			tagStr += "<li class=\"page-item\"><a href=\""+ url +   nextPage + "&size=" + size + sortStr + "\"  class=\"page-link\">다음 &nbsp; </a></li> \n" ;
			tagStr += "<li class=\"page-item\"><a href=\""+ url +   lastPage + "&size=" + size + sortStr + "\"  class=\"page-link\"><i class=\"icon-arrow-right13\"></i></a></li> \n" ;
		}

		tagStr += "</ul>\n";
		
		return tagStr;
	}
}
