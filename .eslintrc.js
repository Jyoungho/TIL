module.exports = {
  parser: "@typescript-eslint/parser",
  parserOptions: {
    project: "tsconfig.json",
    sourceType: "module",
  },
  ignorePatterns: [".eslintrc.js", "dist/**/*.js"],
  plugins: ["@typescript-eslint/eslint-plugin"],
  extends: [
    "plugin:@typescript-eslint/eslint-recommended",
    "plugin:@typescript-eslint/recommended",
    "prettier",
    "prettier/@typescript-eslint",
  ],
  root: true,
  env: {
    node: true,
    jest: true,
  },
  rules: {
    // error
    "@typescript-eslint/method-signature-style": "error",

    // warning
    "prefer-const": "warn",
    "@typescript-eslint/no-use-before-define": "warn",
    "@typescript-eslint/consistent-type-assertions": "warn",
    "@typescript-eslint/ban-types": "warn",
    "@typescript-eslint/no-unused-vars": "warn",

    // off
    "@typescript-eslint/interface-name-prefix": "off",
    "@typescript-eslint/explicit-function-return-type": "off",
    "@typescript-eslint/no-explicit-any": "off",
    "@typescript-eslint/no-inferrable-types": "off",
    "@typescript-eslint/no-empty-interface": "off",
    "@typescript-eslint/no-empty-function": "off",
  },
};
