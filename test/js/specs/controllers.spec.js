describe('ButtonController', function () {
  var ButtonController, scope;

  beforeEach(function () {
    module('myApp');

    inject(function ($controller) {
      scope = {};
      ButtonController = $controller('ButtonController', {
        $scope: scope
      });
    });
  });

  it('should exist', function () {
    expect(!!ButtonController).toBe(true);
  });

  describe('when created', function () {
    it('should define a singleModel property', function () {
      expect(scope.singleModel).toBeDefined();
    });
  });
});
