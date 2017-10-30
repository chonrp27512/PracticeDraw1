###自定义View绘制 第二期：Paint深入详解

	基础的Paint能实现基本的绘制需求，而深入Paint后，能够做出一些更加细致、炫酷的效果。

####Paint的API分为4类：

	*颜色
	*效果
	*drawText()相关
	*初始化

#####一：颜色
	
	Canvas绘制的内容有三层对颜色的处理：
		基本颜色        

		   ↓	1，Canvas.drawColor/ARGB()-颜色参数
		   		2，Canvas.drawBitmap()-bitmap参数
				3，Canvas 图形和文字绘制-paint参数
		ColorFilter
		   ↓    Paint.setColorFileter(colorfilter)
		Xfermode  
				Paint.setXfermode(Xfermode)

#####1，基本颜色 drawColor/RGB/ARGB是直接写在方法的参数里，通过参数来设置；drawBitmap()的颜色是由Bitmap对象来提供的；除此外，是图形和文字的绘制，它们的颜色就需要用Paint参数来额外设置了。
	
	Canvas的方法
		drawColor/RGB/ARGB  
			直接作为参数传入

		drawBitmap()
			与bitmap参的像素颜色相同

		图形和文字(drawCircle()/drawPath()/drawText()...)
			在paint参数中设置
		

Paint设置颜色的方法有两种：一种是直接用Paint.setColor/ARGB()来设置颜色，另一种使用Shader来指定着色方案。

	android的绘制使用Shader，是使用它的子类：
		LinearGradient
		RadialGradient
		SweepGradient
		BitmapShader
		ComposeShader

#####LinearGradient 线性渐变
	
	构造参数：
	x,y,x1,y1：渐变的两个断点的位置
	startColor,endColor：端点的颜色
	tile：断点范围之外的着色规则，类型是TileMode
		CLAMP 会在端点之外延续端点处的颜色
		MIRROR 镜像模式
		REPEAT 重复模式

#####RadialGradient  环形渐变

	参数：
	centerX centerY：辐射中心的坐标
	radius：辐射半径
	centerColor：辐射中心的颜色
	edgeColor：辐射边缘的颜色
	tileMode：辐射范围之外的着色模式。

#####SweepGradient  扫描渐变

	参数：
	cx cy ：扫描的中心
	color0：扫描的起始颜色
	color1：扫描的终止颜色

#####BitmapShader  着色
	
	
