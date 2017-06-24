$(document).ready(function(){
    $('.treeview').click(function(evt){
        
        if($(evt.target).closest('.treeview-menu').length != 0)
            return;
        
        $(this).siblings('.active.open').find('.treeview-menu').slideUp('fast');
        
        $(this).siblings('.active.open').removeClass('open');
        $(this).siblings('.active').removeClass('active');
        $(this).addClass('active');
        
        if($(this).hasClass('open')){
            $(this).find('.treeview-menu').slideUp('fast');
        }
        else{
            $(this).find('.treeview-menu').slideDown('fast');
        }
        $(this).addClass('open');
    }); 
    
    var url = window.location.pathname;
	$('.treeview-menu a').each(function(i,elem){
		if($(elem).attr('href') == url){
			$(elem).closest('li').addClass('active');
			$(elem).closest('.treeview').addClass('active');	
            $(elem).closest('.treeview-menu').slideDown('fast');
            $(elem).addClass('active');
		}
	});
    
    
    $('select.custom').select2();

    $('input.datetimepicker').datetimepicker({   format: 'YYYY-MM-DD'});
});