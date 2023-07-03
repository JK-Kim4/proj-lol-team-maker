let main = {
    init: function (){
        let _this = this;

        $("#playerInsertBtn").on("click", function (){
            _this.insert();
        });
    },
    insert: function (){

        let data = {};

        data.name = $("#inputName").val();
        data.nickName = $("#inputNickName").val();
        data.mainPosition = $("#inputMainPosition").val();
        data.mainTier = $("#inputMainTier").val();
        data.subPosition = $("#inputSubPosition").val();
        data.subTier = $("#inputSubTier").val();

        $.ajax({
            url: "/player/players",
            method: "POST",
            data: JSON.stringify(data),
            success: function (result, textStatus, xhr){
                console.log(xhr.status);
                if(xhr.status == 200 && result > 0){
                    alert("신규 플레이어가 등록되었습니다.")
                    location.href = "/player/list";
                }else{
                    alert("등록 요청이 정상적으로 처리되지않았습니다. [code:" +xhr.status+"]");
                    location.reload();
                }
            },
            error: function (x,h,r){
                console.log(x);
                alert("시스템 오류 발생");
                return;
            }
        });


    },
    getPlayerList: function (){
        $.ajax({
            url: "/player/players",
            method: "GET",
            success: function (result, textStatus, xhr){
                let html = "";
                if(xhr.status == 200){

                    $.each(result, function (index, element){
                        html += "<tr class='addPlayerList' data-player-id='"+element.id+"'>" +
                                    "<td>"+element.id+"</td>" +
                                    "<td><a href='/player/detail/"+element.id+"'>"+element.nickName+"</a></td>" +
                                    "<td>"+element.mainPosition+"</td>" +
                                    "<td>"+element.subPosition+"</td>" +
                                    "<td>"+element.tier+"</td>" +
                                    "<td>"+element.badPlayerRating+"</td>" +
                                "</tr>";

                        $(".addPlayerList").on("click", function (){
                           main.addPlyerToList(this);
                        });
                    });

                    $("#playerListDiv").html(html);
                }
            },
            error: function (x,h,r){
                alert("시스템 오류 발생");
                return;
            }
        });
    },
    addPlyerToList:function (elem){
        console.log(elem);
    }
}

main.init();