#自定义View的三个关键：
	1，布局
	2，绘制
	3，触摸反馈


####自定义View概述
	1，自定义绘制的方式是重写绘制方法，其中最常用的是onDraw()
	2，绘制的关键是Canvas的使用
		canvas的绘制类方法：drawXXX()(关键参数：Paint)
	    canvas的辅助类方法：范围裁剪和几何变换
	4，可以使用不同的绘制方法来控制遮盖关系

####自定义绘制只是的四个级别
	1：Canvas的drawXXX()系列方法及Paint最常见的使用
		画圆，画方，画图，画字。组合这些内容，再配上Paint的一些常见方法来绘制内容的颜色和风格。
	2，Paint（高级颜料）的完全攻略
		设置颜色，空心实心，线条粗细，有没有阴影，拐角形状，开不开双线性过滤，加不加模糊特效。
	3，Canvas对绘制辅助————范围裁剪和几何变换
		范围裁剪（将原本图案裁剪成自己想要的样式）
		几何变换（四个角任意变换位置，3D图形就是靠这个做的）
	4，使用不同的绘制方法来控制绘制顺序（控制顺序解决的并不是[做不到]的问题，而是[性能]问题，同样的效果，你不用绘制顺序的控制往往也能做到，但需要用多个View甚至是多层View才能拼凑出来，因此代价是UI的性能；而使用绘制顺序的控制的话，一个View就能全部搞定）

###Canvas.drawXXX()和Paint基础
★Paint类的常用方法

	*Paint.setStyle(style)设置绘制模式
	*Paint.setColor(int color) 设置颜色
	*Paint.setStrokeWidth(float width) 设置线条宽度
	*Paint.setTextSize(float textsize) 设置文字大小*Paint.		
	*Paint.setAntiAlias(boolean)设置抗锯齿开关
★Canvas.drawColor(@ColorInt int color) 颜色填充(绘制背景颜色，或者在原有绘制效果上加一层半透明的遮罩)

	类似的方法：
		Canvas.drawRGB(int r,int g,int b)
		Canvas.drawARGB(a,r,g,b)
★Canvas.drawCircle(float centerX,float centerY,float radius,Paint paint) 画圆 （注意圆的圆点是前两个参数）

	插播：
		1，Paint.setColor(int color)所画的东西的样式，而不是背景色
		2，Paint.setStyle(Style) 所画的东西的样式，空心，实心，环形
		3，Paint.setStrokeWidth(float width)线条宽度
		4，Paint.setAntAlias(boolean) 抗锯齿，毛边现象，处理边缘处的颜色，看起来更平滑。
★Canvas.drawRect(float left,float top,float right,float bottom,Paint paint)画矩形，左上右下是四条边的坐标

	重载的方法
		Canvas.drawRect(RectF rect,Paint paint);
		Canvas.drawRect(Rect rect,Paint paint);
★Canvas.drawPoint(float x,float y,Paint) 画点 x,y是点的坐标，点的大小可以通过setStrokeWidth来设置，点的形状通过setStroeCap()来设置：ROUND画圆形的点，SQUARE或BUTT是画方形的点。

★Canvas.drawPoints(float[] pts,int offset,int count,Paint paint)
Canvas.drawPoints(float[] pts,Paint paint) 画点（批量） 

	offset:从哪个坐标开始
	count：画几个点（两个数一个点）
★Canvas.drawOval(float left,float top,float right,float bottom,Paint paint)画椭圆，一般画横竖的椭圆，要画斜着的，需要配合几何变换。

★Canvas.drawLines(float[] pts,int offset,int count,Paint paint)/Canvas.drawLines(float[] pts,Paint paint) 画线（批量） 

	drawLines是drawLine()的复数版 4个数一条线

★Canvas.drawRoundRect(float left,float top ,float right,float bottom,float rx,float ry,Paint paint) 画圆角矩形

	left，top，right，bottm是四条边的坐标
	rx和ry是圆角横向半径和纵向半径
	重载方法：
		Canvas.drawRoundRect(RectF rectf,float rx,float ry,Paint paint)

★Canvas.drawArc(float left,float top,float right,float bottom,float startAngle,float sweepAngle,boolean useCenter,Paint paint) 绘制弧形和扇形
	
	drawArc是使用一个椭圆描述弧形的，left，top，right，bottom描述的是这个弧形所在的椭圆
	startAngle是弧形的起始角度（x轴的正想，即正右的方向，是0度的位置；顺时针为正角度，逆时针为负角度）
	sweepAngle是弧形滑过的角度
	useCenter表示是否链接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。

★Canvas.drawPath(Path path,Paint paint)画自定义图形，这个方法是通过描述路径的方式来绘制图形的，它的path参数就是用来描述图形路径的对象。————一般组合图形才用到

◎1：Path方法的第一类：直接描述路径，这一类方法还可以细分为两组：添加子图形和画线（直线和曲线）
	
	第一组：addXXX()——添加子图形
		*addCircle(float x,float y,float radius,Direction dir)添加圆，dir是画圆的路径的方向
		*addOval(float left,float top,float right,float bottom,Direction dir)/*addOval(RectF oval,Direction dir) 添加椭圆
		*addRect(float left,float top,float right,float bottom,Direction dir)/*addRect(RectF rect,Direction dir) 添加矩形
		*addRoundRect(RectF rect,float rx,float ry,Direction dir)/addRountRect(left,top,right,bottom,float[] radii,Direction dir)添加圆角矩形
		*addPath(Path path) 添加咯in过一个Path 

	第二组：xxxTo——画线（直线和曲线），和addXXX()区别在于，第一组是添加的完整封闭图形（除了addPath()），而这组添加的只是一条线
		*lineTo(float x,float y)/rLineTo(float x,float y)画直线
			从当前位置向目标位置画一条直线，x和y是目标位置的坐标。这两个方法的区别是，lineTo(x,y)的参数是绝对坐标，而rLineTo(x,y)的参数是相对于当前坐标。（当前位置即是最后一次调用画Path的方法的终点位置）	
		*quadTo(float x1,float y1,float x2,float y2)/rQuadTo(float x1,float y1,float dx2,float dy2)画二次贝塞尔曲线
			这条二次贝塞尔曲线的起点就是当前位置，而参数中的x1,y1和x2,y2则分别是控制点和重点的坐标。和rLineTo(x,y)同理，rQuadTo(dx1,dy1,dx2,dy2)是相对坐标
			贝塞尔曲线是几何上的一种曲线。它通过起点、控制点、终点来描述一条曲线，主要用于计算图形学。
		*cubicTo(float x1,float y1,float x2,float y2,float x3,float y3)/rCubicTo(float x1,float y1,float x2,float y2,float x3,float y3) 三次贝塞尔曲线，与二次贝塞尔曲线同理。
		*moveTo(float x,float y)/rMoveTo(float x,float y)移动到目标位置	不论是直线还是贝塞尔曲线，都是以当前位置作为起点，而不能指定起点。但是你可以通过moveTo(x,y)或rMoveTo(x,y)来改变当前位置，从而间接地设置这些方法的起点。
		*arcTo(RectF oval,float startAngle,float sweepAngle,boolean forceMoveTo)/arcTo(float left ,float top,float right,float bottom,float startAngle,float sweepAngle,boolean forceMoveTo)/arcTo(RectF oval,float startAngle,float sweepAngle,boolean forceMoveTo)画弧形
			这个方法和Canvas.drawArc()比起来，少了一个参数useCenter，而多了参数forceMoveTo。少了useCenter是因为arcTo()只是用来画弧形而不是画扇形，所以不需要useCenter参数，而多出来的这个forceMoveTo参数的意思是，绘制是要[抬一下笔移过去]，还是[直接拖着笔过去]，区别在于是否留下移动的痕迹。false代表有痕迹，有连接。
			【一个arcTo()，一个addArc()，都是弧形，区别在哪里？其实addArc()只是一个直接使用了forceMoveTo=true的简化版arcTo()】

	close()封闭当前子图形，它的作用是把当前的子图形封闭，即由当前位置向当前子图形的起点绘制一条直线。（close()和lineTo(起点坐标)是完全等价的）。
		[子图形]：官方文档里叫做contour，所谓子图形是指一次不间断的连线。一个Path可以包含多个子图形。当使用第一组方法(addXXX())等方法时候，每一次方法调用都是新增一个独立的子图形；而如果使用的第二组方法(xxxTo())等方法的时候，则是每一次断线（即抬笔），都标志着一个子图形的结束，以及一个新的子图形的开始。
		另外，不是所有的在图形都需要使用close()来封闭。当需要填充图形时（即Paint.Style为FILL或FILL_AND_STROKE），Path会自动封闭子图形。

	
◎2：Path方法第二类：辅助的设置或计算：这类的方法使用场景比较少
	
	*setFillType(FillType filltype)设置填充的方式，设置相交时填充算法

★Canvas.drawBitmap(Bitmap bitmap,float left,float top,float right,float bottom,Paint paint) 画bitmap

	绘制Bitmap对象，也就是把这个Bitmap中的像素内容贴过来。其中left和top是要把bitmap绘制到的位置坐标。它的使用非常简单。
	drawBitmap(bitmap,200,100,paint);
	它的重载方法：
		drawBitmap(bitmap,Rect src,RectF dst,Paint paint)
		drawBitmap(bitmap,Rect src,Rect dst,Paint paint)
		drawBitmap(bitmap,Matrix matrix,Paint paint)
	drawBitmap还有一个兄弟方法drawBitmapMesh()，可以绘制具有网格拉伸效果的Bitmap。drawBitmapMesh()是使用场景较少。
★Canvas.drawText(String text,float x,float y,Paint paint) 绘制文字
	
	界面所有的显示内容，都是绘制出来的，包括文字。drawText()这个方法就是用来绘制文字的。参数text是用来绘制的字符串，x和y是绘制的起点坐标。
	canvas.drawText(text,200,100,paint);

	插播：
		Paint.setTextSize(float textSize)
		通过Paint.setTextSize(float)，可以设置文字的大小