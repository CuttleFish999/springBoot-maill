function loginBtnEven() {
	$(document).ready(function() {
		$("#loginBtn").click(function(e) {
			e.preventDefault();
			var formData = $("#loginForm").serialize();
			$.ajax({
				type: "POST",
				url: "/Emp/register",
				data: formData,
				success: function(response) {
					console.log(response);
					// 在這裡，確保後端返回的數據或狀態碼表示成功，然後再進行重定向
					window.location.href = "loginS";
				},
				error: function(error) {
					console.log(error);
					// 在這裡處理錯誤情況
				}
			});
			return false; // 阻止表單的默認提交行為
		});
	});

}