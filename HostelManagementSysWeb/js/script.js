document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.querySelector("form");

    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (username === "your_username" && password === "your_password") {
            window.location.href = "dashboard.html";
        } else {
            alert("Invalid username or password");
        }
    });
});
