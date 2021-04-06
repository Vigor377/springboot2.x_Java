$(function () {
    $('#login').click(function(){
        $.post("http://localhost/index.php",
            {
                username:$('#username').val(),
                password:$('#password').val()
            },
            function(data,status){
                alert("Êý¾Ý: \n" + data + "\n×´Ì¬: " + status);
            });
    });
});
