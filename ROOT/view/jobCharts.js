$(document).ready(function()

{
	var url_pre = 'http://172.20.10.9:8080/';
	$.get(url_pre + "GetAreasList", function(data,status)
	{
		var area = eval('(' + data + ')');
		console.log(area);			
		option = '';
		$.each(area.AreasList, function(index, value)
		{
			option += '<option>' + value + '</option>';
		});
		$('.area').append(option);
  	});

	$(".search").click(function()
	{
		var jobs = '';
		$(".jobs input").each(function()
		{
			jobs =  jobs + $(this).val() + ',';	
		});
		var area = $(".jobs select").val();	
		
		var url = url_pre + "JobsDistribut?jobs=" + jobs + "&area=" + area;
		
		$('.search_tip').css({"visibility":"visible"});
		$.get(url,function(data,status)
		{
			setTimeout(function()
			{
				$('.search_tip').css({"visibility":"hidden"});
			},1000);
			var data = eval('(' + data + ')'); 
			console.log(data);
			Highcharts.setOptions(
			{  
				lang:
				{
					numericSymbols: null
				}
			});  
			
			$('#container').highcharts(
			{
				chart: 
				{
					type: 'line'
				},
				exporting:
				{  
					enabled: false
				}, 
				credits:
				{
					enabled: false
				},
				title: 
				{
					text: '岗位需求与待遇分布图'
				},
				subtitle: 
				{
					text: '数据来源: python爬虫抓取'
				},
				xAxis: 
				{
					categories: data.SalaryRange
				},
				yAxis: 
				{
					title: 
					{
						text: '岗位数量'
					}
				},
				plotOptions: 
				{
					line: 
					{
						dataLabels: 
						{
							enabled: false         // 开启数据标签
						},
						enableMouseTracking: true // 关闭鼠标跟踪，对应的提示框、点击事件会失效
					}
				},
				series: data.Jobs
			});
		});
	});
});
