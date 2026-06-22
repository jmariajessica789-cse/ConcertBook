document.addEventListener('DOMContentLoaded', () => {
    const regForm = document.getElementById('regForm');

    if (regForm) {
        regForm.addEventListener('submit', function(e) {
    e.preventDefault();

    const name = document.getElementById('fullName').value.trim();
    const email = document.getElementById('email').value.trim();
    const phone = document.getElementById('phone').value.trim();
    const pass = document.getElementById('pass').value;
    const confirmPass = document.getElementById('confirmPass').value;

    // Passwords match
    if (pass !== confirmPass) {
        showRegModal(
            "⚠️",
            "Oops!",
            "Passwords do not match. Please double-check!"
        );
        return;
    }

    // Password length
    if (pass.length < 6) {
        showRegModal(
            "⚠️",
            "Weak Password",
            "Password must be at least 6 characters."
        );
        return;
    }

    // Check if account already exists
    const existingUser = JSON.parse(localStorage.getItem('user'));

    if (existingUser && existingUser.email === email) {
        showRegModal(
            "⚠️",
            "Account Exists",
            "An account with this email already exists."
        );
        return;
    }

    // Save complete user data
    const userData = {
        name: name,
        email: email,
        phone: phone,
        password: pass,
        city: "",
        isLoggedIn: true
    };

    localStorage.setItem('user', JSON.stringify(userData));
    localStorage.setItem('userProfile', JSON.stringify(userData));
    localStorage.setItem('isLoggedIn', 'true');

    const btn = document.querySelector('.btn-primary');
    btn.innerText = "Creating Account...";
    btn.disabled = true;

    setTimeout(() => {
        window.location.assign("index.html");
    }, 1000);
});
    }
});

// Modal Control Functions
function showRegModal(icon, title, message) {
    document.getElementById('modalIcon').innerText = icon;
    document.getElementById('modalTitle').innerText = title;
    document.getElementById('modalMessage').innerText = message;
    document.getElementById('regModal').style.display = 'flex';
}

function closeRegModal() {
    document.getElementById('regModal').style.display = 'none';
}