<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0);">MiniTwitter</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><twt:loggedInUserFullName/> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><label class="hlabel">@<sec:username/></label></li>
                        <li role="separator" class="divider"></li>
                        %{--<li><a href="#">Profile</a></li>--}%
                        %{--<li role="separator" class="divider"></li>--}%
                        <li><g:link controller="home" action="settings">Settings</g:link></li>
                        <li><a class="logout" href="/logout">Log out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>