$(function () {

  $('#alunos-table').DataTable({
        "scrollY": window.innerHeight - 230 - $('[id^=alunos-table]').height(),
        "scrollX": true,
        "scrollCollapse": true,
        "paging": false, // false to disable pagination (or any other option)
        "bInfo": false,
        "deferRender": true,
        "ordering": false        
   });

    $('.dataTables_length').removeClass('bs-select');

});