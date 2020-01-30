

		$(document).ready(function() {
			$.fn.clearForm = function() {
				return this.each(function() {
				var type = this.type, tag = this.tagName.toLowerCase();
				if (tag == 'form')
				return $(':input',this).clearForm();
				if (type == 'text' || type == 'password' || tag == 'textarea' || type == 'hidden')
				this.value = '';
				else if (type == 'checkbox' || type == 'radio')
				this.checked = false;
				else if (tag == 'select'){
				this.selectedIndex = -1;}
				});
			};
			$("#userDiv").hide();
			$("table.sortable").tablesorter({headers: {2: {sorter: 'dealID'}, 4: {sorter: 'debtEquityNumber'}, 5: {sorter: 'debtEquityNumber'}}});
			$('#searchAction').click(function(e){
				$('#dealIdErrorBar').removeClass("req-error");
				if(validateBeforeSearch()){
					document.forms[0].action = contextURL + '/searchResults.do?command=searchResults';
					document.forms[0].submit();
				}else{
					$('#dealIdErrorBar').addClass("req-error");
				}
				
			});
			
			$("#lookupUserInfo").click(function(){ 
				var searchCriteria = $("#searchCriteria option:selected").text();
				var searchText = $("#searchText").val();
				var url= contextURL+"/searchResults.do?command=searchUserInfo";
				$("#userDiv").hide();
				$("#userDiv").empty();
				$.post(url, {searchCriteria:searchCriteria,searchText:searchText},function(data){
					var content = $(data).find('#userDiv');
					$("#userDiv").empty().append( content.html() );
					$("#userDiv").show();
				});
				 
			}); 
			$("#clearForm").click(function(e){
				$('#searchForm').clearForm();
				$('#userDiv').hide();
				$(window).scrollTop(100);
			});
		});
		function validateBeforeSearch() {
			var dealId = $('#dealId').val();
			var valid = dealId.match(/\d+-\d+-\d+/g);
			if(dealId != '' && valid != null){
				return true;
			}else if(dealId == ''){
				return true;
			}
			return false;
		}
		function selectUser(id) {
			var ssoid = $(id).val();
			var name = $(id).parent().next().next().text().split(",");
			$('#ssoId').val(ssoid);
			$('#firstNameId').val(name[1]);
			$('#lastNameId').val(name[0]);
		}
		function printPipelineMgmt() {
			window.print();
			return false;
		}
		function exportToExcel() {
			var url=contextURL + "/searchResults.do?command=exportToExcel";
			document.forms[0].action = url;
			document.forms[0].submit();
		}
		function openTransaction(i,dealReqId) {
			document.forms[0].action = contextURL + '/searchResults.do?command=getSearchActionDealDetail&DEALID='+i+'&DealRequestID='+dealReqId;
			document.forms[0].submit();
		}
