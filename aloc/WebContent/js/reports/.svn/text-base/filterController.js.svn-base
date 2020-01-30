/**
 * @author arijit.biswas
 */

$(document).ready( function() {
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
	$('.dateReports').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'm/d/Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
		}
	});
});