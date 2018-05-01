var gulp = require('gulp');
var sass = require('gulp-sass');
var uglify = require('gulp-uglify');
var pump = require('pump');
var pug = require('gulp-pug');
var browserSync = require('browser-sync').create();

// para browserSync
gulp.task('serve', ['sass'], function() {
	
		browserSync.init({
			server: "./public"
		});
	
		gulp.watch("dev/scss/*.scss", ['sass']);
		
		// para que cuando se realice un cambio en el archivo css, se refresque 
		// el navegador
		gulp.watch("public/css/main.css").on('change', browserSync.reload);
		gulp.watch("public/index.html").on('change', browserSync.reload);
		gulp.watch("dev/js/*.js",["comprimir"]);// cuando detecta un cambio en la ruta llama a la tarea comprimir
		gulp.watch("public/js/*.js").on('change', browserSync.reload); // cuando detecta cambio en algun .js de public regresca el navegador
	});


gulp.task('comprimir', function (cb) {
	pump([
			gulp.src('dev/js/*.js'),
			uglify(),
			gulp.dest('public/js')
		],
		cb
	);
});

gulp.task('sass', function(){
	return gulp.src('dev/scss/*.scss')
		.pipe(sass())
		.pipe(gulp.dest('public/css'))
		.pipe(browserSync.stream());
});


gulp.task('pug',function (){
	return gulp.src('dev/index.pug')
		.pipe(pug({
			pretty: true
		}))
		.pipe(gulp.dest('public/'));
});


gulp.task('default', ['serve'],function(){
	gulp.watch('dev/scss/*.scss',['sass']);
	gulp.watch('dev/index.pug',['pug']);
});







