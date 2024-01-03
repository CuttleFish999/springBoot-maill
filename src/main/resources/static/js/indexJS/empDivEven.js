//首頁會員登入燈箱
function empDivEven() {
	const join_member_btn = document.querySelector("#join-member-btn");
	const join_member_btn2 = document.querySelector("#join-member-btn2");
	const member_login_div = document.querySelector(".login_page");
	const member_login_container2 = document.querySelector("#container2");

	const fill_bg = document.querySelector("#fill-bg");
	const signup_page = document.querySelector(".signup_page");

	let btn_is_True = true;
	join_member_btn.addEventListener('click', () => {
		if (btn_is_True) {
			member_login_div.style.display = "block";
			fill_bg.style.display = "block";

		} else {
			member_login_div.style.display = "none";
			fill_bg.style.display = "none";

		}
		btn_is_True = !btn_is_True;
	})
	// 
	let btn_is_True2 = true;
	join_member_btn2.addEventListener('click', () => {
		if (btn_is_True2) {
			member_login_div.style.display = "block";
			fill_bg.style.display = "block";
		} else {
			member_login_div.style.display = "none";
			fill_bg.style.display = "none";
		}
		btn_is_True = !btn_is_True;
	})
	// 
	let login_is_True = true;
	const close_login_div = document.querySelector("#close-login-div");

	close_login_div.addEventListener('click', () => {
		if (close_login_div) {

			member_login_div.style.display = "none";
			fill_bg.style.display = "none";
			signup_page.style.display = "none";
		}

	});

	const close_login_div2 = document.querySelector("#close-login-div2");
	close_login_div2.addEventListener('click', () => {
		if (close_login_div) {

			member_login_div.style.display = "none";
			fill_bg.style.display = "none";
			signup_page.style.display = "none";
		} else {
			member_login_div.style.display = "block";
			fill_bg.style.display = "block";
			signup_page.style.display = "block";
		}

	});
	let show_hideQA = false;
	function show_hide() {
		if (show_hideQA) {
			signup_page.style.display = "block";
			member_login_container2.style.height = "340px"
			member_login_div.style.display = "none";
		} else {
			signup_page.style.display = "none";
			member_login_div.style.display = "block";
		}
		show_hideQA = !show_hideQA;
	}
}

empDivEven();