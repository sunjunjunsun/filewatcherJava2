<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/echarts.min.js" type="text/javascript"></script>

</head>
<body>
<a href="index">返回查询页面</a>

<span style="font-size:10px;color:#CCC;">fail 数量: ${failCount}
pass 数量: ${passTotal}
Total 数量: ${totalCount}</span>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div>
<div id="main" style="width: 600px;height:400px;float: left;"></div>

<div id="main2" style="width: 600px;height:400px;float:right;margin-left:-300px;"></div>
</div>
<div style="margin-top:500px;">
<h1 style="color:blue;font-size:20px;">机种名称 :${boardType}</h1>
</div>

<script type="text/javascript">

var myChart2 = echarts.init(document.getElementById('main2'));
option = {
	    color: ['#3398DB'],
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
	            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: [
	        {
	            type: 'category',
	            data: ['Fail', 'Pass', 'Total'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value'
	        }
	    ],
	    series: [
	        {
	            name: '直接访问',
	            type: 'bar',
	            barWidth: '60%',
	            data: [${failCount},${passTotal},${totalCount}]
	        }
	    ]
	};
myChart2.setOption(option);
</script>



<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
        title: {
            text: '不良统计报表',
            subtext: '${testerName}',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['Fail', 'PASS']
        },
        series: [
            {
                name: '数据来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: ${failCount}, name: 'Fail'},
                    {value: ${passTotal}, name: 'PASS'}
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>



</body>
</html>