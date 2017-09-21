<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Twitter"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
<g:hiddenField name="feedVersion" value="${twt.feedVersion()}"/>
<sec:ifLoggedIn>
    <g:render template="/layouts/fixedTopNav"/>
</sec:ifLoggedIn>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>
<sec:ifLoggedIn>
    <script>
        updateFeedVersion();
    </script>
</sec:ifLoggedIn>
</body>
</html>
