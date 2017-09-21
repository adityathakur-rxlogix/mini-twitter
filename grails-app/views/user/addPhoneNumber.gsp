<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta name="layout" content="main">

</head>
<body>
<div id="login">
    <div class="inner">
        <div class="fheader">Enter your phone.</div>
        <p>Your phone number keeps your account secure, connects you to friends and makes login easier. </p>
        <form action="/user/modifyPhoneNumber" method="POST" id="loginForm" class="cssform" autocomplete="on">
            <p>
                <g:countrySelect name="country" value="ind"/>
            </p>
            <p>
                <input class="text_" name="phone" id="phone" type="text" pattern="[0-9]{10}"  maxlength="10" placeholder="Phone number">
            </p>
            <p>
                <g:hiddenField name="username" value="${userVO?.username}"/>%{--worst way to do, easily exploitable--}%
                <input id="submit" value="Next" type="submit">
            </p>
            <a href="/home/index">Skip</a>
        </form>
    </div>
</div>
<script>
    (function() {
        document.forms['loginForm'].elements['fullName'].focus();
    })();
</script>
</body>
</html>
