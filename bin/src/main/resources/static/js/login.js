function show_hide() {
  let login = document.getElementById("container1");
  // let signup = document.getElementById("container2");
  let copyright = document.getElementById("copyright");
  let fill_bg = document.getElementById("fill-bg");


  if (login.style.display === "none") {
    login.style.display = "block";  //lonin出現
    fill_bg .style.display = "block";  //fill_bg 出現
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    // signup.style.display = "none";  //signup消失

    copyright.style.margin = "200px 0px 0px 0px";
  } else {
    fill_bg.style.display = "none";
    // login.style.display = "none";   //login消失
    // signup.style.display = "block"; //signup出現
    // signup.style.visibility = "visible";
    // copyright.style.margin = "200px 0px 0px 0px";

    // document.getElementById("fullnHme").value = "";
    // document.getElementById("username2").value = "";
    // document.getElementById("password2").value = "";
    // document.getElementById("comfirm_password").value = "";
  }
}