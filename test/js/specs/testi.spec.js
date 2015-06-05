describe('Constant: myConst', function () {
  var myConst;

  beforeEach(function () {
    module('myApp');

    inject(function (_myConst_) {
      myConst = _myConst_;
    });
  });

  it('should exist', function () {
    expect(!!myConst).toBe(true);
  });

  describe('the constant', function () {
    it('should return my expected value', function () {
      expect(myConst).toBe(12);
    });
  });
});

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
