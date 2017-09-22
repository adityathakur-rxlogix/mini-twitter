<div class="tweet panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-10">@${tweet?.createdBy?.username}</div>

            <div class="col-sm-2">
                <g:if test="${tweet.isRecent}">
                    <span class=" label-primary label">NEW!</span>
                </g:if>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">${tweet.text}</div>
        </div>
    </div>
</div>