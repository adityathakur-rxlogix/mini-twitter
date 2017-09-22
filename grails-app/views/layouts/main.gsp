<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Twitter"/>
    </title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>

<body>
<g:render template="/common/toast"/>
<g:hiddenField name="feedVersion" value="${twt.feedVersion()}"/>
<sec:ifLoggedIn>
    <g:render template="/layouts/fixedTopNav"/>
</sec:ifLoggedIn>
<g:layoutBody/>
<div class="footer"></div>
<asset:javascript src="application.js"/>
</body>
</html>
