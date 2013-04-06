function searchPeople(input) {
    $.ajax({
        url: 'searchPeople',
        data: ({
            keyword: input
        }),
        success: function (data) {
            $("#abc").html(data);
        }
    });
}