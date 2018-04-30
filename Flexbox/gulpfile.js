var gulp = require('gulp');
var sass = require('gulp-sass');
var pug = require('gulp-pug');
	

// gulp.task('default', function(){
// 	console.log('Hola mundo!!!');
// });

gulp.task('sass', function(){
	return gulp.src('dev/scss/*.scss')
		.pipe(sass())
		.pipe(gulp.dest('public/css'));
});

gulp.task('pug',function (){
	return gulp.src('dev/index.pug')
		.pipe(pug({
			pretty: true
		}))
		.pipe(gulp.dest('public/'));
});


gulp.task('default',function(){
	gulp.watch('dev/scss/*.scss',['sass']);
	gulp.watch('dev/index.pug',['pug']);
});


