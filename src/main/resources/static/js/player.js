let main = {
    init: function (){
        let _this = this;

        $("#playerInsertBtn").on("click", function (){
            _this.insert();
        });

        $("#movePlayerSavePage").on("click", function (){
           location.href = "/player/save";
        });

        $(document).on("click", ".add-list", function (){
            _this.addPlyerToList(this);
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
            url: "/player/insert",
            method: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result, textStatus, xhr){
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
                        html += "<tr>" +
                                    "<td>"+element.id+"</td>" +
                                    "<td><a href='/player/detail/"+element.id+"'>"+element.nickname+"</a></td>" +
                                    "<td>"+element.mainPosition+"</td>" +
                                    "<td>"+element.subPosition+"</td>" +
                                    "<td>"+element.mainTier+"</td>" +
                                    "<td>"+element.badPlayerRating+"</td>" +
                                    "<td><button class='btn btn-success add-list' data-player-id='"+element.id+"' data-player-name='"+element.nickname+"'> 선택 </button></td>" +
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
    },
    addPlyerToList:function (elem){
        //player list 존재 여부 확인
        let html = "";
        let playerName = elem.getAttribute("data-player-name");
        let playerId = elem.getAttribute("data-player-id");

        //if (player list에 해당 플레이어가 없다면) append
        if(!main.isPlayerExist(playerId)){
            selectedPlayerList.push(playerId);
            html += '<span class="badge badge-dark badge-player-name">'
                        +playerName + '<span style="color:red; font-size: 1em;"><i class="fa-solid fa-x"></i></span>' +
                    '</span>';

            $("#selectedPlayerListDiv").append(html);
        }else{
            //else (player list에 해당 플레이어가 있다면) return
            alert("이미 선택 된 플레이어입니다.");
            return;
        }
    },
    isPlayerExist: function (playerId){
        let result = false;
        for(let id of selectedPlayerList){
            if(id == playerId) result = true;
        }
        return result;
    }
}

main.init();