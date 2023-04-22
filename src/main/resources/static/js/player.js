let main = {
    init: function (){
        let _this = this;
    },
    getPlayerList: function (){
        $.ajax({
            url: "/player/players",
            method: "GET",
            success: function (result, textStatus, xhr){
                let html = "";
                if(xhr.status == 200){

                    $.each(result, function (index, element){
                        html += "<tr>" +
                            "<td>"+element.id+"</td>" +
                            "<td><a href='/player/detail/"+element.id+"'>"+element.nickName+"</a></td>" +
                            "<td>"+element.mainPosition+"</td>" +
                            "<td>"+element.subPosition+"</td>" +
                            "<td>"+element.tier+"</td>" +
                        "</tr>";
                    });

                    $("#playerListDiv").html(html);
                }
            },
            error: function (x,h,r){
                alert("시스템 오류 발생");
                return;
            }
        });
    }
}

main.init();