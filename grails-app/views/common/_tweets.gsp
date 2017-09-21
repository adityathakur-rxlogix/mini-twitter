<div class="tweets-wrapper">
    <g:each var="tweet" in="${tweets}">
        <g:render template="/common/tweet" model="[tweet: tweet]"/>
    </g:each>
</div>
