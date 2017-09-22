<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Twitter - ${user?.name}</title>
</head>
<body>
<div id="page-outer">
    <div id="page-container" class="wrapper wrapper-home">
        <div role="main" class="content-main" id="timeline" tabindex="-1">
            <div class="inner-wrapper">
                <div class="row margin-top-50">
                    <div class="col-md-4 text-right">
                        Name
                    </div>
                    <div class="col-md-7 margin-bottom-10">
                        <form id="basic-form" class="edit-wrapper">
                            <g:textField name="fullName" value="${user?.name}" default-value="${user?.name}" class="soft-disable" disabled="disabled"/>
                            <a href="javascript:void(0)" class="edit">
                                <span class="big-icon glyphicon glyphicon-edit"></span>
                            </a>
                            <a href="javascript:void(0)" class="save" hidden>
                                <span class="big-icon glyphicon glyphicon-ok-sign"></span>
                            </a>
                        </form>

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 text-right">
                        Username
                    </div>
                    <div class="col-md-7 margin-bottom-10">
                        <form id="username-form" class="edit-wrapper">
                            <g:textField name="username" value="${user?.username}" default-value="${user?.username}" class="soft-disable" disabled="disabled"/>
                            <a href="javascript:void(0)" class="edit">
                                <span class="big-icon glyphicon glyphicon-edit"></span>
                            </a>
                            <a href="javascript:void(0)" id="username-save" class="save" hidden>
                                <span class="big-icon glyphicon glyphicon-ok-sign"></span>
                            </a>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 text-right">
                        Email
                    </div>
                    <div class="col-md-7 margin-bottom-10">
                        <input title="Email" type="text" value="${user?.email}" class="disable" disabled>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 text-right">
                        Password
                    </div>
                    <div class="col-md-7 margin-bottom-10">
                        <div class="password-head">
                            <a class="toggle-password-body btn-link" href="javascript:void(0)">Modify</a>
                        </div>
                        <div class="password-body" hidden>
                            <g:form name="password-form" class="form-horizontal" method="POST">
                                <g:passwordField name="currentPassword" class="margin-top-10  margin-bottom-10" placeholder="Current password"/>
                                <g:passwordField name="newPassword" class="margin-bottom-10" placeholder="New password"/>
                                <g:passwordField name="confirmPassword" class="margin-bottom-10" placeholder="Confirm password"/>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input type="submit" class="btn-sm btn-primary width-100" value="Modify"/>
                                        <input type="button" class="close-password-body btn-sm btn-default width-100 margin-left-5" value="Cancel"/>
                                    </div>
                                </div>
                            </g:form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
