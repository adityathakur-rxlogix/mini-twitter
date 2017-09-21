<!DOCTYPE html>
<html class="no-js" lang="en"><head>
    <meta name="layout" content="main">
</head>
<body>
<div class="signin-dialog-body">
    <div><g:img dir="images" file="twitter-banner.jpg" width="100%"/></div>
    <hr>
    <div><b style="color: #1c2280;">Log in to your account</b></div>
    <form action="/login/authenticate" method="POST" id="loginForm" class="LoginForm" autocomplete="off">
        <div class="LoginForm-input LoginForm-username">
            <input class="text-input email-input" name="username" autocomplete="username" placeholder="Email or username" type="text">
        </div>

        <div class="LoginForm-input LoginForm-password">
            <input class="text-input" name="password" placeholder="Password" autocomplete="current-password" type="password">
        </div>

        <div class="LoginForm-rememberForgot">
            <label>
                <input value="1" name="remember-me" checked="checked" type="checkbox">
                <span>Remember me</span>
            </label>
            <span class="separator">·</span>
            <a class="forgot" href="/begin_password_reset" rel="noopener">Forgot password?</a>
        </div>

        <input class="EdgeButton EdgeButton--primary EdgeButton--medium submit" value="Log in" type="submit">
    </form>
    <div class="signup SignupForm">
        <div class="SignupForm-header">New to Twitter?</div>
        <a href="/register" role="button" class="EdgeButton EdgeButton--secondary EdgeButton--medium u-block js-signup" data-component="signup_callout" data-element="dropdown">Sign up
        </a>
    </div>
</div>
<script>
    (function() {
        document.forms['loginForm'].elements['username'].focus();
    })();
</script>
</body>
</html>
