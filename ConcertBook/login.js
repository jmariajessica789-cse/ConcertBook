document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');

    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('pass').value;

    const savedUser = JSON.parse(localStorage.getItem('user'));

if (!savedUser) {
    alert("No account found. Please register first.");
    return;
}

if (email !== savedUser.email) {
    alert("Email not found.");
    return;
}

if (password !== savedUser.password) {
    alert("Incorrect password.");
    return;
}

    localStorage.setItem('isLoggedIn', 'true');

    const btn = document.querySelector('.btn-primary');
    btn.innerText = "Authenticating...";
    btn.disabled = true;

    setTimeout(() => {
        window.location.assign("index.html");
    }, 1000);
});
    }
});

function showLoginModal(message) {
    document.getElementById('modalMessage').innerText = message;
    document.getElementById('loginModal').style.display = 'flex';
}

function closeLoginModal() {
    document.getElementById('loginModal').style.display = 'none';
}