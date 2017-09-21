<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta name="layout" content="main">
</head>

<body>
<div class="signin-dialog-body">
    <div><g:img dir="images" file="twitter-banner.jpg" width="100%"/></div>
    <hr>
    <div><b style="color: #1c2280;">Join Twitter today.</b></div>

    <form action="/user/signup" method="POST" id="loginForm" class="LoginForm" autocomplete="on">
        <div class="LoginForm-input">
            <input name="fullName" id="fullName" type="text" placeholder="Your name" value="${userVO?.fullName}"
                   required>
        </div>

        <div class="LoginForm-input">
            <input class="text-input email-input" name="email" id="email" type="email"
                   placeholder="Email or username" value="${userVO?.email}" required>
        </div>

        <div class="LoginForm-input">
            <input class="text-input" name="password" id="password" type="password" placeholder="Password" required>
        </div>
        <input class="EdgeButton EdgeButton--primary EdgeButton--medium submit" id="submit" value="Sign up"
               type="submit">
    </form>

    <div class="signup SignupForm">
        <div class="SignupForm-header">Have an account?</div>
        <a href="/" role="button" class="EdgeButton EdgeButton--secondary EdgeButton--medium u-block js-signup"
           data-component="signup_callout" data-element="dropdown">Log in
        </a>
    </div>
</div>
<script>
    (function () {
        document.forms['loginForm'].elements['fullName'].focus();
    })();
</script>
</body>
</html>
