.SILENT:

pre-commit:
	pre-commit run --all-files

update-hooks:
	pre-commit autoupdate

install-hooks:
	pre-commit install --install-hooks

scan:
	@echo "Gradle Testing w/ --scan report"
	@echo "---------------------------------------------------"
	@echo
	gradle test --warning-mode all --scan
	@echo
	@echo "---------------------------------------------------"
	@echo "Scan complete."
	@echo
