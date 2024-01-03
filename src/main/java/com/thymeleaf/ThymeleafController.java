package com.thymeleaf;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.rtn.contant.RtnCateGory;
import com.rtn.dto.RtnQueryParams;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Validated
@Controller
@ComponentScan(basePackages = "com")
public class ThymeleafController {
	@Autowired
	public RtnService rtnService;
	
//	後端首頁
	@GetMapping("/BackStage")
	public String index(Model model) {
		return "BackStage/index";
	}
	
//	條件查詢:根據原因查詢
	@GetMapping("/Rtns")
	public ResponseEntity<List<Rtn>> getAllRtns(
//		查詢條件 Filtering
			@RequestParam(required = false) RtnCateGory rtnCateGory, @RequestParam(required = false) String search,
//		排序條件Sorting
			@RequestParam(defaultValue = "rtnDate") String rtnDate, @RequestParam(defaultValue = "desc") String sort,
//		分頁Pagination
			@RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
			@RequestParam(defaultValue = "0") @Min(0) Integer offset) {
		RtnQueryParams rtnQueryParams = new RtnQueryParams();
//		查詢條件 Filtering		
		rtnQueryParams.setRtnCateGory(rtnCateGory);
		rtnQueryParams.setSearch(search);
//		排序條件Sorting
		rtnQueryParams.setRtnDate(rtnDate);
		rtnQueryParams.setSort(sort);
//		分頁Pagination
		rtnQueryParams.setLimit(limit);
		rtnQueryParams.setOffset(offset);

		List<Rtn> RtnList = rtnService.getAllRtns(rtnQueryParams);

		return ResponseEntity.status(HttpStatus.OK).body(RtnList);
	}


	@GetMapping("/Rtn")
	public String Rtn(Model model) {

//		取得所有Rtn資料
		Integer rtnCount = rtnService.getAllRtnIdCount();
		List<Rtn> rtn = rtnService.getAllRtnData();
//		注入QueryButtonEven資料

		List<String> QueryButtonValue = rtnService.getAllKeepRtnWhy();

		model.addAttribute("rtnCount", rtnCount);
		model.addAttribute("rtn1", rtn);
		model.addAttribute("QueryButtonValue", QueryButtonValue);
		return "/BackStage/Rtn";
	}

	@GetMapping("/Rtnmodify")
	public String updateProduct(@RequestParam(name = "rtnNo", required = false) Integer rtnNo, Model model) {
		if (rtnNo != null) {
			Rtn rtnPuting = rtnService.getProductById(rtnNo);
			model.addAttribute("rtnPuting", rtnPuting);
		}
		return "Rtnmodify";
	}

	@PutMapping("/Rtnmodify/{RtnNoId}")
	public ResponseEntity<Rtn> updateProduct(@PathVariable Integer RtnNoId,
			@RequestBody @Valid RtnRequest rtnRequeset) {
//    	判斷數據是否存在
		Rtn rtn = rtnService.getProductById(RtnNoId);
		System.out.println(rtn == null);
		if (rtn == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
//    		修改數據
			rtnService.updateRtn(RtnNoId, rtnRequeset);
			Rtn updatedRtn = rtnService.getProductById(RtnNoId);
			System.out.println(RtnNoId);
			return ResponseEntity.status(HttpStatus.OK).body(updatedRtn);
		}
	}

	@Autowired
	private EmpService empService;

	@PostMapping("/Emp/register")
	public String register(@ModelAttribute @Valid EmpRegisterRequest empRegisterRequest) {
		// 使用 empRegisterRequest 進行註冊邏輯...

		Emp emp = empService.getUserById(empRegisterRequest);
		if (emp == null) {
			System.out.println("no");
			return "loginF";
		}
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpPsw());
		System.out.println(empRegisterRequest.getEmpName());
		System.out.println(empRegisterRequest.getEmpPsw());
		
		System.out.println(empRegisterRequest.getEmpName() == emp.getEmpName() && empRegisterRequest.getEmpPsw() == emp.getEmpPsw());
		
		if (empRegisterRequest.getEmpName().equals(emp.getEmpName()) && empRegisterRequest.getEmpPsw().equals(emp.getEmpPsw())) {
			System.out.println("ok");
			return "loginS";
		}
		return "loginF";
	}
}

//	public ModelAndView register() {

//		Emp empName = empService.getUserById(empRegisterRequest);

//		return new ModelAndView(redirectView);
//	}

//    @PutMapping("/Rtnmodify/{RtnNoId}")
//    public ResponseEntity<Rtn> updateProduct(@PathVariable Integer RtnNoId,
//    										 @RequestBody @Valid RtnRequest rtnRequeset){
////    	判斷數據是否存在
//    	Rtn rtn = rtnService.getProductById(RtnNoId);
////    	System.out.println(rtn);
//    	if(rtn == null) {
//    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    	}else {
////    		修改數據
//    		rtnService.updateRtn(RtnNoId, rtnRequeset);
//    		Rtn updatedRtn = rtnService.getProductById(RtnNoId);
//    		return ResponseEntity.status(HttpStatus.OK).body(updatedRtn);
//    	}
//    	
//    	return Rtnmodify
//	
//    }

//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//
//    @PostMapping("/login")
//    public String login(String userName,
//                        String userPassword) {
//
//        System.out.println("userName 為: " + userName);
//        System.out.println("userPassword 為: " + userPassword);
//
//        return "login";
//    }
//}
