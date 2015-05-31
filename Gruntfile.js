module.exports = function(grunt) {
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
  });

  grunt.loadNpmTasks('grunt-contrib-jasmine');
  grunt.loadNpmTasks('grunt-contrib-jshint');

  grunt.initConfig({
    jasmine: {
      runSpecs: {
        src: 'public/javascripts/*.js',
        options: {
          specs: 'test/js/specs/**/*.spec.js',
          vendor: [
            'node_modules/angular/angular.js',
            'node_modules/angular-route/angular-route.js',
            'node_modules/angular-mocks/angular-mocks.js'
          ],
          summary: true
        }
      }
    },
    jshint: {
      all: ['Gruntfile.js', 'public/javascripts/**/*.js', 'test/js/**/*.js']
    }
  });

  grunt.registerTask('build', function() {});  // Empty for now
  grunt.registerTask('test', ['jasmine', 'jshint']);
  grunt.registerTask('default', ['test']);
};
