layui.use(['element', 'jquery', 'layer', 'laytpl','laypage','form','table'], function() {
	var $ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		laypage=layui.laypage,
		form=layui.form,
		element = layui.element,
		table = layui.table;
	  
	  table.render({
	    elem: '#order_tb'
	    ,url:'../static/api/order.json'
	    ,cols: [[
	      {field:'orderId', title:'订单编号', width:120, fixed: 'left',unresize: true,  sort: true}
	      ,{field:'consigneeName', title:'收货人姓名', width:120}
	      ,{field:'address', title:'收货地址', width:220}
	      ,{field:'zip', title:'邮政编码', width:100, sort: true}
	      ,{field:'phoneNumber', title:'联系方式', width:120}
	      ,{field:'status', title:'订单状态',width:90,templet: function(res){
			  if(res.status){
				  return '<span class="layui-badge layui-bg-blue">已发货</span>';
			  }
	        return '<span class="layui-badge">待发货</span>';
	      }}
	      ,{field:'createTime', title:'创建时间', width:120}
	      ,{fixed: 'right', title:'操作', toolbar: '#order_tb_bar', width:200}
	    ]]
	    ,page: true
		,limit:5
		,limits:[5,15,30,60,100]
	  });
	  
	  
	  //监听行工具事件
	  table.on('tool(order_tb)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'cancel'){
	      layer.confirm('真的取消行么', function(index){
	        obj.del();
			$("#order-items").html("");
	        layer.close(index);
	      });
	    } else if(obj.event === 'detail'){
	      //渲染订单明细
			laytpl($("#order-item-tpl").html()).render(data.orderItems,function(html){
				$("#order-items").html(html);
			});
	    }
	  });
	  
	  
});