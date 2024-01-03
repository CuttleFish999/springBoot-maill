function updateTable(data) {
	let tbody = document.querySelector("tbody");

	// 清空表格內容
	tbody.innerHTML = "";

	// 將新資料加入表格
	data.forEach(function(rtn) {
		let newRow = tbody.insertRow();
		// 使用 for 迴圈，一一將資料加入每一列
		for (let key in rtn) {
			let cell = newRow.insertCell();
			cell.className = "Rtn-Table-td";
			let keyValue = rtn[key]; // 取得 rtn[key] 的值

			switch (key) {
				case "rtnNo":
				case "rtnDate":
				case "rtnWhy":
				case "refundAmount":
				case "rtnStatus":
					cell.innerText = keyValue;
					break;
				case "empNo":
					cell.innerText = keyValue.empNo;
					break;
				case "orderNo":
					// 						cell.innerText = keyValue.ordNo;
					cell.innerText = "等order model";
					break;
				case null:
					cell.innerText = "沒有資料";
					break;
			}
		}
		// 在最後一列加入修改按鈕
		let modifyCell = newRow.insertCell();
		modifyCell.innerHTML = '<button onclick="redirectToModifyPage('
			+ rtn.rtnNo + ')" class="modify-btn">修改</button>';
	});
}

updateTable(data);