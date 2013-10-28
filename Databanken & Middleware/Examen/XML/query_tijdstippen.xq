xquery version "1.0";

<data>
	{
		let $document := doc("markup.xml")
		for $x in $document//festival[@naam="tomorrowland"]/dag[@id="3"]/artiesten/artiest
		order by $x/start
		return
			<artiest>
				<naam>{$x/naam}</naam>
				<uur>{$x/start}</uur>
			</artiest>
	}
</data>