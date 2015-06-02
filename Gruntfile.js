module.exports = function(grunt) {
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
  });

  grunt.loadNpmTasks('grunt-contrib-jasmine');
  grunt.loadNpmTasks('grunt-contrib-jshint');

  grunt.initConfig({
    jasmine: {
      specsAndCoverage: {
        src: 'public/javascripts/*.js',
        options: {
          specs: 'test/js/specs/**/*.spec.js',
          vendor: [
            'node_modules/angular/angular.js',
            'node_modules/angular-route/angular-route.js',
            'node_modules/angular-mocks/angular-mocks.js'
          ],
          summary: true,
          template: require('grunt-template-jasmine-istanbul'),
          templateOptions: {
            coverage: 'grunt-coverage/coverage.json',
            report: [
              {
                type: 'text'
              },
              {
                type: 'html',
                options: {
                  dir: 'grunt-coverage/html'
                }
              },
              {
                type: 'lcovonly',
                options: {
                  dir: 'grunt-coverage/lcov'
                }
              }
            ],
            thresholds: {
              lines: 70,
              statements: 70,
              branches: 70,
              functions: 80
            }
          }
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
