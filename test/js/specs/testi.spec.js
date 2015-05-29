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
