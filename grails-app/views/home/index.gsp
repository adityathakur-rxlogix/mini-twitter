<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Twitter - ${user?.name}</title>
    <asset:javascript src="home.js"/>
</head>
<body>
<div id="page-outer">
    <div id="page-container" class="wrapper wrapper-home">
        <div role="main" class="content-main" id="timeline" tabindex="-1">
            <div class="tweet-box">
                <g:form controller="home" action="tweet" class="tweet-form">
                    <div class="tweet-content">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-10">
                                    <input id="tweetText" class="form-control" name="tweetText" type="text" placeholder="What's happening?" maxlength="140">
                                </div>
                                <div class="col-sm-2">
                                    <button class="tweet-action EdgeButton EdgeButton--primary js-tweet-btn disable" type="button" disabled="disabled">
                                        <span class="button-text tweeting-text">
                                            Tweet
                                        </span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </g:form>
            </div>
            <div class="tweets-wrapper-outer">
                <g:render template="/common/tweets" model="[tweets: tweets]"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
