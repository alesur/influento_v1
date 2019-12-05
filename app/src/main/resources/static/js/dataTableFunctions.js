  (function($) {
    "use strict";
    $(function () {

      // Datatables
      $('#example1').DataTable({
        "lengthMenu": [[50, 100, 200, -1], [50, 100, 200, "All"]],
        responsive: true,
        "autoWidth": false
      });

    })
  })(jQuery)