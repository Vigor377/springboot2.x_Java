$(function () {
    $('#login').click(function(){
        $.post("http://localhost/index.php",
            {
                username:$('#username').val(),
                password:$('#password').val()
            },
            function(data,status){
                alert("����: \n" + data + "\n״̬: " + status);
            });
    });
});
