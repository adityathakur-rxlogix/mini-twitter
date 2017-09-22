// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require jquery.validate.min
//= require bootstrap.min
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

$(document).ready(function () {
    var toastSelector = $('.toast-dimissable');
    toastSelector.find('.close').on('click', function () {
       toastSelector.hide();
    });
});

function toast(msg, type) {
    var toastSelector = $('#toast-div');
    toastSelector.removeClassStartingWith('alert-');
    toastSelector.addClass('toast-dismissable' + type?type:'alert-info');
    toastSelector.find('span').html(msg);
    toastSelector.show();

}

$.fn.removeClassStartingWith = function (filter) {
    $(this).removeClass(function (index, className) {
        return (className.match(new RegExp("\\S*" + filter + "\\S*", 'g')) || []).join(' ')
    });
    return this;
};



