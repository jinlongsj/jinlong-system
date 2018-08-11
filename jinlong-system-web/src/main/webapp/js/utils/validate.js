$(function(){
/////////////////////////////////////////////////////////////			
$('input.required,select.required,textarea.required').each(function(){
	$(this).after('<sup class="requiredSup" title="必填项">*</sup>');	
});

$('form').submit(function(){
	var ok=true;
	var info='';
	var osubmit=$(this);
	$('input,select,textarea').removeClass('error');
	
	$(this).find(':input:visible').each(function(i){
		obj=$(this);
		 if(obj.hasClass('required')&&obj.val()==''){//required
			info='<span class="dia-span-info"><strong>'+obj.parent('td').prev().find('div').text().replace('：','')+'</strong>是必填项目</span>';
			obj.addClass('error');
		 	$('<div class="dia" style="font-family:宋体;font-size:20px;" >'+info+'</div>').dialog({bgiframe:false,width:'300px',position:'center' ,autoOpen: true,modal:true,draggable: false,resizable:false,stack:true});
		 	setTimeout(function(){$('.dia').dialog('close')},1200);
			obj.trigger('focus');
			ok=false;
			return false;
		}
		 else if(obj.val()!=''&&obj.hasClass('email')&&!(obj.val().match(/^\w+@[a-zA-Z_0-9]+\.[a-zA-Z]{2,3}$/))){//email
			info='<span class="dia-span-info"><strong>'+obj.parents('td').prev().find('div').text().replace('：','')+'</strong>必须有效</span>';
			obj.addClass('error');
			$('<div class="dia"  style="font-family:宋体;font-size:20px;">'+info+'</div>').dialog({bgiframe:true,width:'300px',autoOpen: true,modal:true,draggable: true,resizable:false,stack:true});
		 	setTimeout(function(){$('.dia').dialog('close')},1200);
			obj.trigger('focus');
			ok=false;
			return false;
		}
		 else if(obj.val()!=''&&obj.hasClass('phone')&&!(obj.val().match(/^[0-9\-]+$/))){//phone
			info='<span class="dia-span-info"><strong>'+obj.parents('td').prev().text().replace('：','')+'</strong>必须有效</span>';
			obj.addClass('error');
			$('<div class="dia" style="font-family:宋体;font-size:20px;" >'+info+'</div>').dialog({bgiframe:true,width:'300px',autoOpen: true,modal:true,draggable: true,resizable:false,stack:true});
		 	setTimeout(function(){$('.dia').dialog('close')},1200);
			obj.trigger('focus');
			ok=false;
			return false;
		}
		 else if(obj.val()!=''&&obj.hasClass('int')&&!(obj.val().match(/^-?[0-9]+$/))){//int
			info='<span class="dia-span-info"><strong>'+obj.parents('td').prev().text().replace('：','')+'</strong>必须是整数</span>';
			obj.addClass('error');
			$('<div class="dia"  style="font-family:宋体;font-size:20px;">'+info+'</div>').dialog({bgiframe:true,width:'300px',autoOpen: true,modal:true,draggable: true,resizable:false,stack:true});
		 	setTimeout(function(){$('.dia').dialog('close')},1200);
			obj.trigger('focus');
			ok=false;
			return false;
		}else if(obj.val()!=''&&obj.hasClass('num')&&isNaN(obj.val())){//int
			info='<span class="dia-span-info"><strong>'+obj.parents('td').prev().text().replace('：','')+'</strong>必须是数字</span>';
			obj.addClass('error');
			$('<div class="dia"  style="font-family:宋体;font-size:20px;">'+info+'</div>').dialog({bgiframe:true,width:'300px',autoOpen: true,modal:true,draggable: true,resizable:false,stack:true});
		 	setTimeout(function(){$('.dia').dialog('close')},1200);
			obj.trigger('focus');
			ok=false;
			return false;
		}
		 return ok;
	})
	return ok;
});

$('textarea').each(function(){
	if(!isNaN($(this).attr('maxlength'))){
		$(this).after('<span class="textLimit" title="字数限制为：'+$(this).attr('maxlength')+'"><div class="numDiv"><span class="num"></span></div></span>');
		var textLeft=$(this).parent().find('.textLimit span.num')
		$(this).limit($(this).attr('maxlength'),textLeft);
	}
})

$('select.select').each(function(){
	var svalue = $(this).attr('value')
	$(this).children().each(function(){
		var ovalue = $(this).attr('value')
		if(svalue==ovalue)
		{
			$(this).attr('selected','selected');			
		}
	})
})
//截取子串
$('.substr').each(function(){
	var content = $(this).text();
	var mlength = content.length;
    if(mlength>20)
   	{
   		var subcontent = content.substring(0,20)+"...";
   		$(this).html('<span title='+content+'>'+subcontent+'</span');
   	}
})

//只有在IE下正常
$('th.toggleCheckboxAll .checkbox').bind('click',function(){
if($(this).attr('ischecked')=='0')
{
	$(this).attr('ischecked','1');
	$(this).attr('checked','checked');
	$('tbody').find('input[type="checkbox"]').each(function(){
		$(this).attr('ischecked','1');
		$(this).attr('checked','checked');
	})
}
else
{
	$(this).attr('ischecked','0');
	$(this).removeAttr('checked','checked');
	$('tbody').find('input[type="checkbox"]').each(function(){
		$(this).attr('ischecked','0');
		$(this).removeAttr('checked','checked');
	})
}
});

$('tbody').find('input[type=checkbox]').bind('click',function(){
if($(this).attr('ischecked')=='0')
{
	$(this).attr('ischecked','1');
	$(this).attr('checked','checked');
}
else
{
	$(this).attr('ischecked','0');
	$(this).removeAttr('checked','checked');
}
});

/////////////////////////////////////////////////////////////
})