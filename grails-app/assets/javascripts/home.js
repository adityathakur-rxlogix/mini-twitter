var randomNumber = 5000;

$(document).ready(function () {

    $('#tweetText').on('keyup', function () {
        var tweetBtn  = $('.js-tweet-btn');
        if (this.value.trim().length !== 0){
            tweetBtn.removeClass('disable');
            tweetBtn.removeAttr('disabled')
        } else {
            tweetBtn.addClass('disable');
            tweetBtn.attr('disabled');
        }
    });

    $('.js-tweet-btn').on('click', function () {
        $('.tweet-form').submit();
    });

    $('.tweet-form').on('submit', function (e) {
        e.preventDefault();
        var tweetBtn = $('.js-tweet-btn');
        var tweetTxtSelector = $('#tweetText');
        var tweetTxt = tweetTxtSelector.val();
        if (tweetTxt.trim().length !== 0) {
            $.ajax({
                method: "POST",
                url: "/home/postTweet",
                data: $(this).serialize()
            })
                .done(function (response) {
                    if(response.status) {
                        tweetTxtSelector.val('');
                        tweetBtn.addClass('disable');
                        tweetBtn.attr('disabled');
                    }
                    toast(response.message, 'alert-success');
                });
        }
    });
});

function reloadTweetsWidget() {
    $.post('/home/fetchLatestTweets').done(function (response) {
        $('.tweets-wrapper-outer').html(response.html);
    });
}


function updateFeedVersion() {
    setInterval(function() {
        randomNumber = generateRandomNumb(5000, 7000);
        $.get('/home/updateFeedVersion').done(function (response) {
            var feedVersionField = $('#feedVersion');
            var serverVersion = response.feedVersion;
            var clientVersion = feedVersionField.val();
            if(serverVersion && serverVersion > clientVersion) {
                reloadTweetsWidget();
                feedVersionField.val(serverVersion);
            }
        });
    }, randomNumber);
}

function generateRandomNumb(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}