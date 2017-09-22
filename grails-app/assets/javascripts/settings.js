$(document).ready(function () {

    $('.toggle-password-body').on('click', function () {
        $('.password-body').toggle();
    });

    $('.close-password-body').on('click', function () {
        $('#password-form')[0].reset();
        $('.password-body').hide();
    });

    $('.edit-wrapper .edit').on('click', function () {
        var editIcon = $(this);
        var parentSelector = editIcon.parent();
        var inputField = parentSelector.find('input');
        var saveIcon = parentSelector.find('.save');
        if (inputField[0].hasAttribute('disabled')) {
            inputField.removeAttr('disabled');
            inputField.removeClass('soft-disable');

        } else {
            inputField.attr('disabled', 'disabled');
            inputField.addClass('soft-disable');
            inputField.val(inputField.attr('default-value'));
            parentSelector.find('label').hide();
        }
        editIcon.find('span').toggleClass('glyphicon-edit glyphicon-remove-sign');
        editIcon.find('span').toggleClass('red');
        saveIcon.toggle();
    });

    $('#basic-form').validate({
        rules: {
            fullName: {
                required: true
            }
        },
        messages: {
            fullName: "Please enter a valid name."
        },
        submitHandler: function (form) {
            var formSelector = $(form);
            $.ajax({
                method: "POST",
                url: "/home/updateFullName",
                data: formSelector.serialize()
            }).done(function (response) {
                alert(response.message);
                if (response.status) {
                    var inputField = formSelector.find('input');
                    var saveIcon = formSelector.find('.save');
                    var editIcon = formSelector.find('.edit');
                    inputField.attr('disabled', 'disabled').addClass('soft-disable');
                    editIcon.find('span').toggleClass('glyphicon-edit glyphicon-remove-sign');
                    editIcon.find('span').toggleClass('red');
                    saveIcon.toggle();
                }
            });
            return false;
        }
    });

    $('#username-form').validate({
        rules: {
            username: {
                required: true,
                remote: "/home/checkIfUsernameNotExists"
            }
        },
        messages: {
            username: {
                required: "Please enter a valid username.",
                remote: 'Username already exists.'
            }
        },
        submitHandler: function (form) {
            var formSelector = $(form);
            $.ajax({
                method: "POST",
                url: "/home/updateUsername",
                data: formSelector.serialize()
            }).done(function (response) {
                alert(response.message);
                if (response.status) {
                    var inputField = formSelector.find('input');
                    var saveIcon = formSelector.find('.save');
                    var editIcon = formSelector.find('.edit');
                    inputField.attr('disabled', 'disabled').addClass('soft-disable');
                    editIcon.find('span').toggleClass('glyphicon-edit glyphicon-remove-sign');
                    editIcon.find('span').toggleClass('red');
                    saveIcon.toggle();
                }
            });
            return false;
        }
    });

    $('.save').on('click', function (e) {
        e.preventDefault();
        var form = $(this).parent();
        form.submit();
        return false;
    });

    $('#password-form').validate({
        rules: {
            currentPassword: {
                required: true
            },
            newPassword: {
                required: true,
                minlength: 6
            },
            confirmPassword: {
                equalTo: "#newPassword"
            }
        },
        messages: {
            currentPassword: "Please enter your existing password.",
            newPassword: {
                required: "New password is required.",
                minlength: "Password should be minimum {0} characters."
            },
            confirmPassword: "Confirm password should match new password"
        },
        submitHandler: function (form) {
            var formSelector = $(form);
            $.ajax({
                method: "POST",
                url: "/home/updatePassword",
                data: formSelector.serialize()
            }).done(function (response) {
                toast(response.message);
                if(response.status) {
                    $('.close-password-body').click();
                }
            });
            return false;
        }
    });

});