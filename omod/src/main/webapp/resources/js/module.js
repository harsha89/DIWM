var $j = jQuery.noConflict();

$j(document).ready(function() {
    $j('#table').dataTable( {
        "bFilter": true,
        "iDisplayLength": 15,
        "bProcessing": true,
        "bJQueryUI": true,
        "sPaginationType": "full_numbers",
        "aaSorting": [[ 6, "desc" ]],
        "aoColumns": [
            { "bSearchable": true,
                "bVisible":    true },
            { "bSearchable": true,
                "bVisible":    true },
            { "bSearchable": true,
                "bVisible":    true },
            { "bSearchable": true,
                "bVisible":    true },
            { "bSearchable": true,
                "bVisible":    true },
            { "bSearchable": true,
                "bVisible":    true }
        ]

    } );

    $j("#checkboxColumn").find('span').removeClass('ui-icon');

    $j('.status').each(function() {
        this.innerHTML=renderStatus(this.innerHTML);
    });

} );

$j('#selectAll').click(function() {
    if(this.checked) {
        // Iterate each checkbox
        $j(':checkbox').each(function() {
            this.checked = true;
        });
    }else {
        $j(':checkbox').each(function() {
            this.checked = false;
        });
    }
});

function renderStatus(status) {
    if(status == "0") { return "New"; }
    if(status == "1") { return "Ignored"; }
    if(status == "2") { return "Voided"; }
    return "Other";
}

function showDiv(action)
{
    if('assign'==action) {
    $j('#removeDiv').hide('slow');
    $j('#assignDiv').slideToggle();
    }
    else {
        $j('#assignDiv').hide('slow');
        $j('#removeDiv').slideToggle();
    }
}

function checkForAssignAssignees()
{
    var selected = new Array();
    $('#checkboxes input:checked').each(function() {
        selected.push($(this).attr('name'));
    });

    $j('#tableRecords tbody tr td:nth-child(2)').each(function() {
        var a=$j(this).text();
    });
}

function checkForRemoveAssignees()
{

}


