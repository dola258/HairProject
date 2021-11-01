package hairline.base;

import hairline.impl.CustomerActionDelete;	
import hairline.impl.CustomerActionInfo;
import hairline.impl.CustomerActionList;
import hairline.impl.CustomerActionRegister;
import hairline.impl.DesignerActionInsert;			
import hairline.impl.DesignerActionLogin;
import hairline.impl.DesignerActionMember;
import hairline.impl.ReserveActionCalendar;
import hairline.impl.ReserveActionDelete;
import hairline.impl.ReserveActionInsert;
import hairline.impl.ReserveActionList;
import hairline.impl.ReserveActionUpdate;
import hairline.impl.CustomerActionSearch;
import hairline.impl.CustomerActionUpdate;
import hairline.impl.CustomerActionUpdateForm;

public class ActionFactory {

	public Action getAction(String command) {
		System.out.println(command);

		Action action = null;
		
		switch( command ) {
		case "LOGIN": // 로그인 확인
			action = new DesignerActionLogin();
			break;
		case "DINSERT": // 디자이너 회원가입
			action = new DesignerActionInsert();
			break;
		case "SEARCH": // 고객검색으로 이동(예약관리 페이지)
			action = new CustomerActionSearch();
			break;
		case "LIST":    // 고객 검색 리스트(예약관리 페이지) 
			action = new CustomerActionList();
			break;
		case "CAL":     // 달력으로 이동
			action = new ReserveActionCalendar();
			break;
		case "RINSERT": // 예약추가
			action = new ReserveActionInsert();
			break;
		case "RESERVE": // 선택 날짜의 예약리스트
			action = new ReserveActionList();
			break;
		case "RDELETE": // 예약삭제
			action = new ReserveActionDelete();
			break;
		case "DELETE":   	// 고객 목록 삭제
			action = new CustomerActionDelete();
			break;
		case "INFO":   		// 고객 조회
			action = new CustomerActionInfo();
			break;
		case "REGISTER":   // 신규 고객 등록
			action = new CustomerActionRegister();
			break;
		case "RUPDATE": // 예약 업데이트
			action = new ReserveActionUpdate();
			break;
		case "UPDATEFORM":   // 고객 편집 폼
			action = new CustomerActionUpdateForm();
			break;
		case "UPDATE":   // 고객 편집
			action = new CustomerActionUpdate();
			break;

			
			
			
			
		}
		return action;
	}


}
