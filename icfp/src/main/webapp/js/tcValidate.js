// Generated by CoffeeScript 1.3.1
(function() {

  $(function() {
    $("updateStatusForm").validate({
      rules: {
    	changeAfterApprovalFlag: "required",
    	changeTypeComments: {
          required: function(element) {
            if ($('input[name=changeAfterApprovalFlag]').val() === 'Yes') {
              return true;
            }
          }
        },
        changeTypeId:{
            required: function(element) {
                if ($('input[name=changeAfterApprovalFlag]').val() === 'Yes') {
                  return true;
                }
              }
            }
      },
      errorPlacement: function(error, element) {
    	  
        if ($(element).attr('name') === 'changeAfterApprovalFlag' ) {
        	$(element).closest('.radio-container').addClass('req-error');
        }else if($(element).attr('name') === 'changeTypeId'){
        	$(element).closest('.radio-container').addClass('req-error');
        }else{
			$(element).parent().find('span.req-error').show();
		}
      },
      success: "valid",
      ignore: ":hidden",
      onfocusout: false,
      focusCleanup: true
    });
    
    $('#certify').find('.btn-success').click(function() {
      $("updateStatusForm").validate();
    });
  });

}).call(this);
